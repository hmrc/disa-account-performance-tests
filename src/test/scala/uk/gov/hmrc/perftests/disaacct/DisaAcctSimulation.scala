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

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.disaacct.AuthRequests.{navigateToAuthLoginStubPage, submitLogin}
import uk.gov.hmrc.perftests.disaacct.AuthorisedUsersChangeRequests._
import uk.gov.hmrc.perftests.disaacct.ChangeInformationRequests.{navigateToChangeInformationPage, postSectionSelectionFromChangeInformationPage}
import uk.gov.hmrc.perftests.disaacct.ChangeOfCircumstancesRequests.navigateToChangeOfCircumstancesPage
import OrganisationDetailsChangeRequests._
import ProductInformationChangeRequests._



class DisaAcctSimulation extends PerformanceTestRunner {

  setup("ISA-Manager-Account Maintenance", "ISA Manager Account Maintenance- DISA Change Signatory Journey") withRequests (
    navigateToAuthLoginStubPage,
    submitLogin("Z1234","change-information","signatory@example.com"),
    navigateToChangeInformationPage,
    postSectionSelectionFromChangeInformationPage,
    navigateToChangeOfCircumstancesPage,
    getTradingNameChangePage,
    postTradingNamePage,
    getEnterYourOrganisationAddressPage,
    postEnterYourOrganisationAddressPage,
    getOrganisationTelephoneNumberPage,
    postOrganisationTelephoneNumberPage,
    getOrganisationEmailAddressPage,
    postOrganisationEmailAddressPage,
    getEmailVerificationCodePage,
    postEmailVerificationCodePage,
    navigateToISAProductsPage,
    postISAProducts,
    getInnovativeFinancialProductsPage,
    postInnovativeFinancialProducts,
    getPeerToPeerLoansPage,
    postPeerToPeerLoansPlatform,
    getFcaPlatformNumberPage,
    postFcaPlatformNumber,
    getFcaArticlesPage,
    postFcaArticlesPage,
    getAddedLiaisonOfficersPage,
    getCheckLiaisonOfficersDetailPage,
    getChangeLiaisonOfficersNamePage,
    postChangeLiaisonOfficersNamePage,
    getChangeLiaisonOfficersEmailPage,
    postChangeLiaisonOfficersEmailPage,
    getChangeLiaisonOfficersPhoneNumberPage,
    postChangeLiaisonOfficersPhoneNumberPage,
    getChangeLiaisonOfficersCommsPrefPage,
    postChangeLiaisonOfficersCommsPrefPage,
    getAddedSignatoriesPage,
    getCheckSignatoryDetailPage,
    getChangeSignatoryNamePage,
    postChangeSignatoryNamePage,
    getChangeSignatoryJobTitlePage,
    postChangeSignatoryJobTitlePage)

  runSimulation()

}
