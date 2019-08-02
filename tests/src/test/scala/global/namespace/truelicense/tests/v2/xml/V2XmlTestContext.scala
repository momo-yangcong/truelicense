/*
 * Copyright (C) 2005 - 2019 Schlichtherle IT Services.
 * All rights reserved. Use is subject to license terms.
 */
package global.namespace.truelicense.tests.v2.xml

import global.namespace.truelicense.api.LicenseManagementContextBuilder
import global.namespace.truelicense.tests.core.ExtraData
import global.namespace.truelicense.tests.v2.core.V2TestContext
import global.namespace.truelicense.v2.xml.{V2Xml, V2XmlContext}
import javax.xml.bind._

trait V2XmlTestContext extends V2TestContext {

  final override def managementContextBuilder: LicenseManagementContextBuilder = {
    V2Xml builder new V2XmlContext {

      override def jaxbContext(factory: V2XmlContext.JAXBContextFactory): JAXBContext = {
        super.jaxbContext(classes => factory(classes :+ classOf[ExtraData]))
      }
    }
  }

  override def extraData: AnyRef = {
    val bean = new ExtraData
    bean.setMessage("This is some private extra data!")
    bean
  }

  lazy val licenseDtoClass: Class[V2XmlLicenseDTO] = classOf[V2XmlLicenseDTO]
}
