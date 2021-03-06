/*
 * Copyright 2020 ACINQ SAS
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

package fr.acinq.bitcoin.crypto

import fr.acinq.secp256k1.Hex
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalStdlibApi::class)
class Ripemd160TestsJvm {
    @Test
    fun `very long input`() {
        val ripemd160 = Ripemd160()
        val input = "abcdefghbcdefghicdefghijdefghijkefghijklfghijklmghijklmnhijklmno".encodeToByteArray()
        for (i in 0L until 167773) ripemd160.update(input, 0, input.size)
        val output = ByteArray(20)
        ripemd160.doFinal(output, 0)
        assertTrue { output.contentEquals(Hex.decode("c22925cae5c03927e9a5e8cdb7f5449b2aa4efac")) }
    }
}