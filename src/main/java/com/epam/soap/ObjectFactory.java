
package com.epam.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAvailableAmount_QNAME = new QName("http://soap.Web.epam.com/", "getAvailableAmount");
    private final static QName _GetAvailableAmountResponse_QNAME = new QName("http://soap.Web.epam.com/", "getAvailableAmountResponse");
    private final static QName _MakeIncomeResponse_QNAME = new QName("http://soap.Web.epam.com/", "makeIncomeResponse");
    private final static QName _MakeWithdrawResponse_QNAME = new QName("http://soap.Web.epam.com/", "makeWithdrawResponse");
    private final static QName _MakeWithdraw_QNAME = new QName("http://soap.Web.epam.com/", "makeWithdraw");
    private final static QName _MakeIncome_QNAME = new QName("http://soap.Web.epam.com/", "makeIncome");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MakeIncome }
     * 
     */
    public MakeIncome createMakeIncome() {
        return new MakeIncome();
    }

    /**
     * Create an instance of {@link MakeWithdraw }
     * 
     */
    public MakeWithdraw createMakeWithdraw() {
        return new MakeWithdraw();
    }

    /**
     * Create an instance of {@link MakeWithdrawResponse }
     * 
     */
    public MakeWithdrawResponse createMakeWithdrawResponse() {
        return new MakeWithdrawResponse();
    }

    /**
     * Create an instance of {@link MakeIncomeResponse }
     * 
     */
    public MakeIncomeResponse createMakeIncomeResponse() {
        return new MakeIncomeResponse();
    }

    /**
     * Create an instance of {@link GetAvailableAmountResponse }
     * 
     */
    public GetAvailableAmountResponse createGetAvailableAmountResponse() {
        return new GetAvailableAmountResponse();
    }

    /**
     * Create an instance of {@link GetAvailableAmount }
     * 
     */
    public GetAvailableAmount createGetAvailableAmount() {
        return new GetAvailableAmount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableAmount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.Web.epam.com/", name = "getAvailableAmount")
    public JAXBElement<GetAvailableAmount> createGetAvailableAmount(GetAvailableAmount value) {
        return new JAXBElement<GetAvailableAmount>(_GetAvailableAmount_QNAME, GetAvailableAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableAmountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.Web.epam.com/", name = "getAvailableAmountResponse")
    public JAXBElement<GetAvailableAmountResponse> createGetAvailableAmountResponse(GetAvailableAmountResponse value) {
        return new JAXBElement<GetAvailableAmountResponse>(_GetAvailableAmountResponse_QNAME, GetAvailableAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeIncomeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.Web.epam.com/", name = "makeIncomeResponse")
    public JAXBElement<MakeIncomeResponse> createMakeIncomeResponse(MakeIncomeResponse value) {
        return new JAXBElement<MakeIncomeResponse>(_MakeIncomeResponse_QNAME, MakeIncomeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeWithdrawResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.Web.epam.com/", name = "makeWithdrawResponse")
    public JAXBElement<MakeWithdrawResponse> createMakeWithdrawResponse(MakeWithdrawResponse value) {
        return new JAXBElement<MakeWithdrawResponse>(_MakeWithdrawResponse_QNAME, MakeWithdrawResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeWithdraw }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.Web.epam.com/", name = "makeWithdraw")
    public JAXBElement<MakeWithdraw> createMakeWithdraw(MakeWithdraw value) {
        return new JAXBElement<MakeWithdraw>(_MakeWithdraw_QNAME, MakeWithdraw.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MakeIncome }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.Web.epam.com/", name = "makeIncome")
    public JAXBElement<MakeIncome> createMakeIncome(MakeIncome value) {
        return new JAXBElement<MakeIncome>(_MakeIncome_QNAME, MakeIncome.class, null, value);
    }

}
