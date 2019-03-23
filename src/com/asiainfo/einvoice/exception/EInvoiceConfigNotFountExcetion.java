package com.asiainfo.einvoice.exception;

/**
 * Created by huangjh on 16/3/28.
 */
public class EInvoiceConfigNotFountExcetion extends Exception {
    private Throwable ex;

    public EInvoiceConfigNotFountExcetion()
    {
        super((Throwable)null);
    }

    public EInvoiceConfigNotFountExcetion(String paramString)
    {
        super(paramString, null);
    }

    public EInvoiceConfigNotFountExcetion(String paramString, Throwable paramThrowable)
    {
        super(paramString, null);
        this.ex = paramThrowable;
    }

    public Throwable getException()
    {
        return this.ex;
    }

    public Throwable getCause()
    {
        return this.ex;
    }
}
