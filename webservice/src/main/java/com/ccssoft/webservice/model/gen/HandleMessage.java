//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.3.0 生成的
// 请访问 <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a>
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2019.03.07 时间 10:29:58 AM CST
//

package com.ccssoft.webservice.model.gen;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * anonymous complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="handleMessage" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {
      "callerSystem",
      "callerPwd",
      "interfaceType",
      "form",
    })
@XmlRootElement(
    name = "handleMessage",
    namespace = "http://service.pboss.js.chinamobile.com/SG2PBOSSService")
public class HandleMessage {

  @XmlElement(required = true)
  protected String callerSystem;

  @XmlElement(required = true)
  protected String callerPwd;

  @XmlElement(required = true)
  protected String interfaceType;

  @XmlElement(required = true)
  protected String form;

  public String getCallerSystem() {
    return callerSystem;
  }

  public void setCallerSystem(String callerSystem) {
    this.callerSystem = callerSystem;
  }

  public String getCallerPwd() {
    return callerPwd;
  }

  public void setCallerPwd(String callerPwd) {
    this.callerPwd = callerPwd;
  }

  public String getInterfaceType() {
    return interfaceType;
  }

  public void setInterfaceType(String interfaceType) {
    this.interfaceType = interfaceType;
  }

  public String getForm() {
    return form;
  }

  public void setForm(String form) {
    this.form = form;
  }

  @Override
  public String toString() {
    return "HandleMessage{"
        + "callerSystem='"
        + callerSystem
        + '\''
        + ", callerPwd='"
        + callerPwd
        + '\''
        + ", interfaceType='"
        + interfaceType
        + '\''
        + ", form='"
        + form
        + '\''
        + '}';
  }
}
