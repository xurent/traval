package com.xurent.keshe.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper  {

    HttpServletRequest orgRequest = null;
	
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
        
        orgRequest = request;
	}

	
    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values==null)  {
                    return null;
            }
        int count = values.length;
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
                   encodedValues[i] = xssEncode(values[i]);
         }
        return encodedValues;
      }
    
    
    @Override
    public String getParameter(String name) {
    	
        String value = super.getParameter(xssEncode(name));
        System.out.println("before name:"+name +"   value:"+value);
        if (value != null) {
            value = xssEncode(value);
        }
        System.out.println("after name:"+name +"   value:"+value);
        return value;
    }
    /**
     * ����getHeader���������������Ͳ���ֵ����xss���ˡ�<br/>
     * �����Ҫ���ԭʼ��ֵ����ͨ��super.getHeaders(name)����ȡ<br/>
     * getHeaderNames Ҳ������Ҫ����
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }
    /**
     * ����������xss©���İ���ַ�ֱ���滻��ȫ���ַ�
     *
     * @param s
     * @return
     */
    private static String xssEncode(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }else if(!s.contains("<script")&&!s.contains("</script>")&&s.contains("<img")) {
        	return s;
        }
        StringBuilder sb = new StringBuilder(s.length() + 16);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
            case '>':
                sb.append('��');// ȫ�Ǵ��ں�
                break;
            case '<':
                sb.append('��');// ȫ��С�ں�
                break;
            case '\'':
                sb.append('��');// ȫ�ǵ�����
                break;
            case '\"':
                sb.append('��');// ȫ��˫����
                break;
            case '&':
                sb.append('��');// ȫ��
                break;
            case '\\':
                sb.append('��');// ȫ��б��
                break;
            case '#':
                sb.append('��');// ȫ�Ǿ���
                break;
            case '%':    // < �ַ��� URL ������ʽ��ʾ�� ASCII �ַ���ʮ�����Ƹ�ʽ�� ��: %3c
                processUrlEncoder(sb, s, i);
                break;
            default:
                sb.append(c);
                break;
            }
        }
        return sb.toString();
    }
    public static void processUrlEncoder(StringBuilder sb, String s, int index){
        if(s.length() >= index + 2){
            if(s.charAt(index+1) == '3' && (s.charAt(index+2) == 'c' || s.charAt(index+2) == 'C')){    // %3c, %3C
                sb.append('��');
                return;
            }
            if(s.charAt(index+1) == '6' && s.charAt(index+2) == '0'){    // %3c (0x3c=60)
                sb.append('��');
                return;
            }            
            if(s.charAt(index+1) == '3' && (s.charAt(index+2) == 'e' || s.charAt(index+2) == 'E')){    // %3e, %3E
                sb.append('��');
                return;
            }
            if(s.charAt(index+1) == '6' && s.charAt(index+2) == '2'){    // %3e (0x3e=62)
                sb.append('��');
                return;
            }
        }
        sb.append(s.charAt(index));
    }
    /**
     * ��ȡ��ԭʼ��request
     *
     * @return
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }
    /**
     * ��ȡ��ԭʼ��request�ľ�̬����
     *
     * @return
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }
        return req;
    }
}
