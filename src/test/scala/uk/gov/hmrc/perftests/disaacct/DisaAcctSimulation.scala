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
import uk.gov.hmrc.perftests.disaacct.LiaisonOfficersRequests._
import uk.gov.hmrc.perftests.disaacct.ChangeInformationRequests.{navigateToChangeInformationPage, postSectionSelectionFromChangeInformationNonSignatoryPage, postSectionSelectionFromChangeInformationSignatoryPage}
import uk.gov.hmrc.perftests.disaacct.ChangeOfCircumstancesRequests.navigateToChangeOfCircumstancesPage
import OrganisationDetailsChangeRequests._
import ProductInformationChangeRequests._
import uk.gov.hmrc.perftests.disaacct.SignatoryRequests._
import uk.gov.hmrc.perftests.disaacct.utils.RandomDataGenerator.generateRandomZReference

class DisaAcctSimulation extends PerformanceTestRunner {

  setup("ISA-Manager-Account-Signatory-Change", "ISA Manager Account- DISA Signatory Change Journey") withRequests (
    navigateToAuthLoginStubPage,
    submitLogin(generateRandomZReference(1000, 9999),"change-information","signatory@example.com"),
    navigateToChangeInformationPage,
    postSectionSelectionFromChangeInformationSignatoryPage,
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
    navigateToAddedLiaisonOfficersPage,
    PostAddedLiaisonOfficersPage,
    getAddedSignatoryPage,
    getCheckSignatoryDetailPage,
    getChangeSignatoryNamePage,
    postChangeSignatoryNamePage,
    getChangeSignatoryJobTitlePage,
    postChangeSignatoryJobTitlePage)

  setup("ISA-Manager-Account-Signatory-Remove", "ISA Manager Account- DISA Signatory Remove Journey") withRequests (
    navigateToAuthLoginStubPage,
    submitLogin(generateRandomZReference(1000, 9999),"change-information","signatory@example.com"),
    navigateToChangeInformationPage,
    postSectionSelectionFromChangeInformationSignatoryPage,
    navigateToChangeOfCircumstancesPage,
    getAddedLiaisonOfficersPage,
    getRemoveLiaisonOfficersPage,
    PostRemoveLiaisonOfficersPage,
    PostAddedLiaisonOfficersPage,
    getAddedSignatoryPage,
    getRemoveSignatoryPage,
    PostRemoveSignatoryPage,
    PostAddedSignatoryPage)

  setup("ISA-Manager-Account-Non-Signatory-Change", "ISA Manager Account- DISA Change NonSignatory Journey") withRequests (
    navigateToAuthLoginStubPage,
    submitLogin(generateRandomZReference(1000, 9999),"change-information","user@test.com"),
    navigateToChangeInformationPage,
    postSectionSelectionFromChangeInformationNonSignatoryPage,
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
    getCheckLiaisonOfficersDetailPage,
    navigateToAddedLiaisonOfficersPage,
    PostAddedLiaisonOfficersPage)

  setup("ISA-Manager-Account-Non-Signatory-Remove", "ISA Manager Account- DISA Non Signatory Remove Journey") withRequests (
    navigateToAuthLoginStubPage,
    submitLogin(generateRandomZReference(1000, 9999),"change-information","user@test.com"),
    navigateToChangeInformationPage,
    postSectionSelectionFromChangeInformationNonSignatoryPage,
    navigateToChangeOfCircumstancesPage,
    getAddedLiaisonOfficersPage,
    getRemoveLiaisonOfficersPage,
    PostRemoveLiaisonOfficersPage,
    PostAddedLiaisonOfficersPage
  )

  runSimulation()

}
