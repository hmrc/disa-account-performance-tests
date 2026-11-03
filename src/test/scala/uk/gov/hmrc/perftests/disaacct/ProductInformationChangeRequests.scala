/*
 * Copyright 2025 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.disaacct

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.disaacct.constants.AppConfig.{disaBaseUrl, disaRoute}

object ProductInformationChangeRequests extends ServicesConfiguration {

  val navigateToISAProductsPage: HttpRequestBuilder =
    http("Navigate to Change ISA product Page")
      .get(s"$disaBaseUrl$disaRoute/change-products")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postISAProducts: HttpRequestBuilder =
    http("Post Change ISA Products Page")
      .post(s"$disaBaseUrl$disaRoute/change-products": String)
      .formParam("value[0]", "cashIsas")
      .formParam("value[2]", "stocksAndSharesIsas")
      .formParam("value[4]", "innovativeFinanceIsas")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/change-of-circumstances").saveAs("ManageOrganisationInformationPage")
      )

  val getInnovativeFinancialProductsPage: HttpRequestBuilder =
    http("Get Change Innovative Products Page")
      .get(s"$disaBaseUrl/innovative-financial-products": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postInnovativeFinancialProducts: HttpRequestBuilder =
    http("Post Change Innovative Finance Products Page")
      .post(s"$disaBaseUrl/innovative-financial-products": String)
      .formParam("value[1]", "peerToPeerLoansUsingAPlatformWith36HPermissions")
      .formParam("value[2]", "crowdfundedDebentures")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(header("location").is(s"$disaRoute/change-of-circumstances"))

  val getPeerToPeerLoansPage: HttpRequestBuilder =
    http("Get Change Peer to Peer Loans Page")
      .get(s"$disaBaseUrl/peer-to-peer-loans": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postPeerToPeerLoansPlatform: HttpRequestBuilder =
    http("Post Change Peer To Peer Loans Platform")
      .post(s"$disaBaseUrl/peer-to-peer-loans": String)
      .formParam("value", "Test Platform")
      .formParam("csrfToken", s"#{csrfToken}")
      .check(status.is(303))
      .check(header("location").is(s"$disaRoute/change-of-circumstances"))

  val getFcaPlatformNumberPage: HttpRequestBuilder =
    http("Get Change FCA Platform Number Page")
      .get(s"$disaBaseUrl/fca-platform-number": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFcaPlatformNumber: HttpRequestBuilder =
    http("Post Change FCA Platform Number")
      .post(s"$disaBaseUrl/fca-platform-number": String)
      .formParam("value", "1234567")
      .formParam("csrfToken", s"#{csrfToken}")
      .check(status.is(303))
      .check(header("location").is(s"$disaRoute/change-of-circumstances"))

  val getFcaArticlesPage: HttpRequestBuilder =
    http("Get Change FCA Article Page")
      .get(s"$disaBaseUrl/fca-articles": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFcaArticlesPage: HttpRequestBuilder =
    http("Post Change FCA Article Page")
      .post(s"$disaBaseUrl/fca-articles": String)
      .formParam("value[3]", "article36H")
      .formParam("csrfToken", s"#{csrfToken}")
      .check(status.is(303))
      .check(header("location").is(s"$disaRoute/change-of-circumstances"))

}
