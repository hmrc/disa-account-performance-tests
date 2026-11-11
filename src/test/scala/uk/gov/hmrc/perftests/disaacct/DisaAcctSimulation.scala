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
import uk.gov.hmrc.perftests.disaacct.AuthRequests.{getAuthLoginStubPage, submitLogin}
import uk.gov.hmrc.perftests.disaacct.LiaisonOfficersRequests._
import uk.gov.hmrc.perftests.disaacct.ChangeInformationRequests._
import OrganisationDetailsChangeRequests._
import ProductInformationChangeRequests._
import uk.gov.hmrc.perftests.disaacct.ChangeOfCircumstancesRequests.{getChangeOfCircumstancesPage}
import uk.gov.hmrc.perftests.disaacct.SignatoryRequests._
import uk.gov.hmrc.perftests.disaacct.utils.RandomDataGenerator.generateRandomZReference

class DisaAcctSimulation extends PerformanceTestRunner {

  setup("ISA-Manager-Account-Signatory-Journey", "ISA Manager Account- DISA Signatory Journey") withRequests (
    getAuthLoginStubPage,
    submitLogin(generateRandomZReference(1000, 9999),"change-information","signatory@example.com"),
    getChangeInformationPage,
    postSectionSelectionFromChangeInformationSignatoryPage,
    getChangeOfCircumstancesPage,
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
    getISAProductsPage,
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
    getRemoveLiaisonOfficersPage,
    postRemoveLiaisonOfficersPage,
    getLiaisonOfficerNamePage,
    postLiaisonOfficerNameFromTheLiaisonOfficerNamePage,
    getLiaisonOfficerEmailPage,
    postEmailAddressFromTheLiaisonOfficerEmailPage,
    getLiaisonOfficerPhoneNumberPage,
    postPhoneNumberFromTheLiaisonOfficerPhoneNumberPage,
    getLiaisonOfficerCommunicationMethodPage,
    postCommunicationMethodFromTheLiaisonOfficerCommunicationPage,
    getCheckAddedLiaisonOfficersCheckYourAnswersPage,
    getCheckLiaisonOfficersDetailPage,
    getChangeLiaisonOfficersNamePage,
    postChangeLiaisonOfficersNamePage,
    getChangeLiaisonOfficersEmailPage,
    postChangeLiaisonOfficersEmailPage,
    getChangeLiaisonOfficersPhoneNumberPage,
    postChangeLiaisonOfficersPhoneNumberPage,
    getChangeLiaisonOfficersCommsPrefPage,
    postChangeLiaisonOfficersCommsPrefPage,
    postAddedLiaisonOfficersPage,
    getAddedSignatoryPage,
    getCheckSignatoryDetailPage,
    getChangeSignatoryNamePage,
    postChangeSignatoryNamePage,
    getChangeSignatoryJobTitlePage,
    postChangeSignatoryJobTitlePage,
    getDeclarationForChanges,
    postDeclarationForChanges,
    getChangesCompletedConfirmation)

  setup("ISA-Manager-Account-Non-Signatory-Journey", "ISA Manager Account- DISA NonSignatory Journey") withRequests (
    getAuthLoginStubPage,
    submitLogin(generateRandomZReference(1000, 9999),"change-information","user@test.com"),
    getChangeInformationPage,
    postSectionSelectionFromChangeInformationNonSignatoryPage,
    getChangeOfCircumstancesPage,
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
    getAddedLiaisonOfficersPage,
    getRemoveLiaisonOfficersPage,
    postRemoveLiaisonOfficersPage,
    getLiaisonOfficerNamePage,
    postLiaisonOfficerNameFromTheLiaisonOfficerNamePage,
    getLiaisonOfficerEmailPage,
    postEmailAddressFromTheLiaisonOfficerEmailPage,
    getLiaisonOfficerPhoneNumberPage,
    postPhoneNumberFromTheLiaisonOfficerPhoneNumberPage,
    getLiaisonOfficerCommunicationMethodPage,
    postCommunicationMethodFromTheLiaisonOfficerCommunicationPage,
    getCheckAddedLiaisonOfficersCheckYourAnswersPage,
    getCheckLiaisonOfficersDetailPage,
    getChangeLiaisonOfficersNamePage,
    postChangeLiaisonOfficersNamePage,
    getChangeLiaisonOfficersEmailPage,
    postChangeLiaisonOfficersEmailPage,
    getChangeLiaisonOfficersPhoneNumberPage,
    postChangeLiaisonOfficersPhoneNumberPage,
    getChangeLiaisonOfficersCommsPrefPage,
    postChangeLiaisonOfficersCommsPrefPage,
    postAddedLiaisonOfficersPage,
    getDeclarationForChanges,
    postDeclarationForChanges,
    getChangesCompletedConfirmation)

  runSimulation()

}
