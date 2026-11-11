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

package uk.gov.hmrc.perftests.disaacct.utils

object RandomDataGenerator {

  val reservedReferences: Set[String] =
    Set("Z1400", "Z1500", "Z1503", "Z0404","Z0202")

  def generateRandomZReference(min: Int, max: Int): String = {
    require(min <= max, "min must be <= max")

    Iterator
      .continually {
        val num = scala.util.Random.nextInt(max - min + 1) + min
        f"Z$num%04d"
      }
      .find(zref => !reservedReferences.contains(zref))
      .get
  }
}
