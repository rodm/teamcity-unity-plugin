/*
 * Copyright 2000-2023 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jetbrains.buildServer.unity.logging

class PackageManagerBlock : LogBlock {

    override val name = blockName

    override val logFirstLine = LogType.Inside

    override val logLastLine = LogType.Inside

    override fun isBlockStart(text: String) = blockStart.containsMatchIn(text)

    override fun isBlockEnd(text: String) = blockEnd.containsMatchIn(text)

    override fun getText(text: String) = text.removePrefix(prefix)

    companion object {
        private const val blockName = "Package Manager"
        private const val prefix = "[$blockName] "
        private val blockStart = Regex(Regex.escape(prefix) + "Registering \\d+ packages?:")
        private val blockEnd = Regex(Regex.escape(prefix) + "Done registering packages in [^\\s]+ seconds")
    }
}