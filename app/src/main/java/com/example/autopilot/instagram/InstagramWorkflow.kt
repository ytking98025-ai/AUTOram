package com.example.autopilot.instagram

/**
 * Instagram Reels workflow placeholder.
 *
 * Recommended production approach:
 * - Use Meta/Instagram's supported publishing APIs where the account and media
 *   type are eligible.
 * - Keep access tokens in Android Keystore / encrypted storage.
 * - Do not automate around login, CAPTCHA, rate limits, or platform restrictions.
 */
class InstagramWorkflow {
    fun validateVideo(path: String): Boolean =
        path.isNotBlank()

    fun buildCaption(title: String, hashtags: List<String>): String {
        return buildString {
            append(title)
            if (hashtags.isNotEmpty()) {
                append("\n\n")
                append(hashtags.joinToString(" ") { if (it.startsWith("#")) it else "#$it" })
            }
        }
    }
}
