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
object AuthorisedUsersChangeRequests extends ServicesConfiguration {

  val getAddedLiaisonOfficersPage: HttpRequestBuilder =
    http("Get Added Liaison Officer Page")
      .get(s"$disaBaseUrl$disaRoute/added-liaison-officers": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCheckLiaisonOfficersDetailPage: HttpRequestBuilder =
    http("Get Check Added Liaison Officer Page")
      .get(s"$disaBaseUrl$disaRoute/check-added-liaison-officer?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getChangeLiaisonOfficersNamePage: HttpRequestBuilder =
    http("Get Change Liaison Officer Name Page")
      .get(s"$disaBaseUrl$disaRoute/change-liaison-officer-name?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeLiaisonOfficersNamePage: HttpRequestBuilder =
    http("Post Change Liaison Officer Name Page")
      .post(s"$disaBaseUrl$disaRoute/change-liaison-officer-name?id=#{formId}": String)
      .formParam("value", "Test Officer")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/check-added-liaison-officer?id=#{formId}").saveAs("Check liaison officer details page")
      )
  val getChangeLiaisonOfficersEmailPage: HttpRequestBuilder =
    http("Get Change Liaison Officer Email Page")
      .get(s"$disaBaseUrl$disaRoute//change-liaison-officer-email?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeLiaisonOfficersEmailPage: HttpRequestBuilder =
    http("Post Change Liaison Officer Email Page")
      .post(s"$disaBaseUrl$disaRoute/change-liaison-officer-email?id=#{formId}": String)
      .formParam("value", "officer@example.com")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/check-added-liaison-officer?id=#{formId}")
      )
  val getChangeLiaisonOfficersPhoneNumberPage: HttpRequestBuilder =
    http("Get Change Liaison Officer Phone Number Page")
      .get(s"$disaBaseUrl$disaRoute//change-liaison-officer-phone-number?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeLiaisonOfficersPhoneNumberPage: HttpRequestBuilder =
    http("Post Change Liaison Officer Phone Number Page")
      .post(s"$disaBaseUrl$disaRoute/change-liaison-officer-phone-number?id=#{formId}": String)
      .formParam("value", "01234567890")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/check-added-liaison-officer?id=#{formId}")
      )
  val getChangeLiaisonOfficersCommsPrefPage: HttpRequestBuilder =
    http("Get Change Added Liaison Officer Page")
      .get(s"$disaBaseUrl$disaRoute//change-liaison-officer-communication?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeLiaisonOfficersCommsPrefPage: HttpRequestBuilder =
    http("Post Change from Liaison Officer Page")
      .post(s"$disaBaseUrl$disaRoute/change-liaison-officer-communication?id=#{formId}": String)
      .formParam("value[0]", "byEmail")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/check-added-liaison-officer?id=#{formId}")
      )

  val getAddedSignatoriesPage: HttpRequestBuilder =
        http("Get Added Signatory Page")
          .get(s"$disaBaseUrl$disaRoute/added-signatories": String)
          .check(status.is(200))
          .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCheckSignatoryDetailPage: HttpRequestBuilder =
    http("Get Check Added Signatory Page")
      .get(s"$disaBaseUrl$disaRoute/check-signatory-details?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getChangeSignatoryNamePage: HttpRequestBuilder =
    http("Get Change Signatory Name Page")
      .get(s"$disaBaseUrl$disaRoute/change-signatory-name?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeSignatoryNamePage: HttpRequestBuilder =
    http("Post Change Signatory Name Page")
      .post(s"$disaBaseUrl$disaRoute/change-signatory-name?id=#{formId}": String)
      .formParam("value", "Test Signatory")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/check-signatory-details?id=#{formId}").saveAs("Check Signatory Details page")
      )
  val getChangeSignatoryJobTitlePage: HttpRequestBuilder =
    http("Get Change Signatory Job Title Page")
      .get(s"$disaBaseUrl$disaRoute/change-signatory-job-title?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postChangeSignatoryJobTitlePage: HttpRequestBuilder =
    http("Post Change Signatory Job Title Page")
      .post(s"$disaBaseUrl$disaRoute/change-signatory-job-title?id=#{formId}": String)
      .formParam("value", "Director")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))
      .check(
        header("location").is(s"$disaRoute/check-signatory-details?id=#{formId}")
      )

}
