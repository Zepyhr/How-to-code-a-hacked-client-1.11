package net.optifine;

public class HttpPipelineRequest
{
    private HttpRequest httpRequest = null;
    private HttpListener httpListener = null;
    private boolean closed = false;

    public HttpPipelineRequest(HttpRequest p_i52_1_, HttpListener p_i52_2_)
    {
        this.httpRequest = p_i52_1_;
        this.httpListener = p_i52_2_;
    }

    public HttpRequest getHttpRequest()
    {
        return this.httpRequest;
    }

    public HttpListener getHttpListener()
    {
        return this.httpListener;
    }

    public boolean isClosed()
    {
        return this.closed;
    }

    public void setClosed(boolean p_setClosed_1_)
    {
        this.closed = p_setClosed_1_;
    }
}
