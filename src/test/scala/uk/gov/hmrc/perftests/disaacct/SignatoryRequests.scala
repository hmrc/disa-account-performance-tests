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

object SignatoryRequests extends ServicesConfiguration {

  val getAddedSignatoryPage: HttpRequestBuilder =
    http("Get Added Signatory Page")
      .get(s"$disaBaseUrl$disaRoute/added-signatories": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
      .check(
        css("a[href*='check-signatory-details']", "href")
          .transform(_.split("id=").last)
          .saveAs("formId"))

  val getRemoveSignatoryPage: HttpRequestBuilder =
    http("Get Remove Signatory Page")
      .get(s"$disaBaseUrl$disaRoute/remove-signatory?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postRemoveSignatoryPage: HttpRequestBuilder =
    http("Post yes from Remove Signatory Page")
      .post(s"$disaBaseUrl$disaRoute/remove-signatory?id=#{formId}": String)
      .formParam("value", "yes")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val postAddedSignatoryPage: HttpRequestBuilder =
    http("Post no from Added Signatory Page")
      .post(s"$disaBaseUrl$disaRoute/added-signatories": String)
      .formParam("csrfToken", "#{csrfToken}")
      .formParam("value", "no")
      .check(status.is(303))
      .check(header("location").is(s"$disaRoute/change-of-circumstances"))

  val getCheckSignatoryDetailPage: HttpRequestBuilder =
    http("Get Check Added Signatory Page")
      .get(s"$disaBaseUrl$disaRoute/check-signatory-details?id=#{formId}": String)
      .check(status.is(200))

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
  val getSignatoryNamePage: HttpRequestBuilder =
  http("Navigate to Signatory Name Page")
    .get(s"$disaBaseUrl$disaRoute/signatory-name?id=#{formId}")
    .check(status.is(200))
    .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postSignatoryNameFromSignatoryNamePage: HttpRequestBuilder =
    http("Post Signatory Name From 'The Signatory Name' Page")
      .post(s"$disaBaseUrl$disaRoute/signatory-name?id=#{formId}": String)
      .formParam("value", "Signatory Name")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getSignatoryJobTitlePage: HttpRequestBuilder =
    http("Get Signatory Job Title Page")
      .get(s"$disaBaseUrl$disaRoute/signatory-job-title?id=#{formId}": String)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postJobTitleFromTheSignatoryJobTitlePage: HttpRequestBuilder =
    http("Post Job title From 'The Signatory Job title' Page")
      .post(s"$disaBaseUrl$disaRoute/signatory-job-title?id=#{formId}": String)
      .formParam("value", "QA")
      .formParam("csrfToken", "#{csrfToken}")
      .check(status.is(303))

  val getAddedSignatoryCheckYourAnswersPage: HttpRequestBuilder =
    http("Get Added Signatory Check Your Answers Page")
      .get(s"$disaBaseUrl$disaRoute/check-signatory-details?id=#{formId}": String)
      .check(status.is(200))

}
