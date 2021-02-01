package club.daixy.demo.agent;

/**
 * @author daixiaoyong
 * @date 2020/1/13 16:41
 * @description
 */
public class Header {

    private String appId;

    private String timestamp;

    private String signType;

    private String authType;

    private String sign;

    public Header(String appId, String timestamp, String signType, String authType, String sign) {
        this.appId = appId;
        this.timestamp = timestamp;
        this.signType = signType;
        this.authType = authType;
        this.sign = sign;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

}
