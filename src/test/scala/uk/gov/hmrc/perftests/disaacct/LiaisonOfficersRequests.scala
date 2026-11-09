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
object LiaisonOfficersRequests extends ServicesConfiguration {

  val getAddedLiaisonOfficersPage: HttpRequestBuilder =
    http("Get Added Liaison Officer Page")
      .get(s"$disaBaseUrl$disaRoute/added-liaison-officers": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
      .check(
        css("a[href*='check-added-liaison-officer']", "href")
          .transform(_.split("id=").last)
          .saveAs("formId"))

  val getRemoveLiaisonOfficersPage: HttpRequestBuilder =
    http("Get Remove Liaison Officer Page")
      .get(s"$disaBaseUrl$disaRoute/remove-liaison-officer?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postRemoveLiaisonOfficersPage: HttpRequestBuilder =
    http("Post yes from Remove Liaison Officer Page")
      .post(s"$disaBaseUrl$disaRoute/remove-liaison-officer?id=#{formId}": String)
      .formParam("value", "yes")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getCheckLiaisonOfficersDetailPage: HttpRequestBuilder =
    http("Get Check Added Liaison Officer Page")
      .get(s"$disaBaseUrl$disaRoute/check-added-liaison-officer?id=#{formId}": String)
      .check(status.is(200))

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
      .get(s"$disaBaseUrl$disaRoute/change-liaison-officer-email?id=#{formId}": String)
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
      .get(s"$disaBaseUrl$disaRoute/change-liaison-officer-phone-number?id=#{formId}": String)
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
      .get(s"$disaBaseUrl$disaRoute/change-liaison-officer-communication?id=#{formId}": String)
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

  val postAddedLiaisonOfficersPage: HttpRequestBuilder =
    http("Post no from Added Liaison Officer Page")
      .post(s"$disaBaseUrl$disaRoute/added-liaison-officers": String)
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "no")
      .check(status.is(303))
      .check(header("location").is(s"$disaRoute/change-of-circumstances"))

  val getLiaisonOfficerNamePage: HttpRequestBuilder =
    http("Navigate to Liaison Officer Name Page")
      .get(s"$disaBaseUrl$disaRoute/liaison-officer-name?id=#{formId}")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postLiaisonOfficerNameFromTheLiaisonOfficerNamePage: HttpRequestBuilder =
    http("Post Liaison Officer Name From 'The Liaison Officer Name' Page")
      .post(s"$disaBaseUrl$disaRoute/liaison-officer-name?id=#{formId}": String)
      .formParam("value", "liaison officer")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getLiaisonOfficerEmailPage: HttpRequestBuilder =
    http("Get Liaison Officer Email Page")
      .get(s"$disaBaseUrl$disaRoute/liaison-officer-email?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postEmailAddressFromTheLiaisonOfficerEmailPage: HttpRequestBuilder =
    http("Post Email Address From 'The Liaison Officer Email' Page")
      .post(s"$disaBaseUrl$disaRoute/liaison-officer-email?id=#{formId}": String)
      .formParam("value", "liaisonofficer@gmail.com")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getLiaisonOfficerPhoneNumberPage: HttpRequestBuilder =
    http("Get Liaison Officer Phone Number Page")
      .get(s"$disaBaseUrl$disaRoute/liaison-officer-phone-number?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postPhoneNumberFromTheLiaisonOfficerPhoneNumberPage: HttpRequestBuilder =
    http("Post Phone Number From 'The Liaison Officer Phone Number' Page")
      .post(s"$disaBaseUrl$disaRoute/liaison-officer-phone-number?id=#{formId}": String)
      .formParam("value", "07000000000")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getLiaisonOfficerCommunicationMethodPage: HttpRequestBuilder =
    http("Get Liaison Officer Communication Method Page")
      .get(s"$disaBaseUrl$disaRoute/liaison-officer-communication?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCommunicationMethodFromTheLiaisonOfficerCommunicationPage: HttpRequestBuilder =
    http("Post Communication Method From 'The Liaison Officer Communication' Page")
      .post(s"$disaBaseUrl$disaRoute/liaison-officer-communication?id=#{formId}": String)
      .formParam("value[0]", "byEmail")
      .formParam("value[1]", "byPhone")
      .formParam("value[2]", "byPost")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getAddedLiaisonOfficersCheckYourAnswersPage: HttpRequestBuilder =
    http("Get Added Liaison Officers Check Your Answers Page")
      .get(s"$disaBaseUrl$disaRoute/check-added-liaison-officer?id=#{formId}": String)
      .check(status.is(200))
}
