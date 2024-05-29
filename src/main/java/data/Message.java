package data;

public class Message {

    public Message(String msgType, String srcId, String dstId, Object content) {
        this.msgType = msgType;
        this.srcId = srcId;
        this.dstId = dstId;
        this.content = content;
    }

    private final String msgType;

    private final String srcId;

    private final String dstId;

    private final Object content;

    public String getMsgType() {
        return msgType;
    }

    public String getSrcId() {
        return srcId;
    }

    public String getDstId() {
        return dstId;
    }

    public Object getContent() {
        return content;
    }

}