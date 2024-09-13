package com.example.unfollowersinstagram.data.models

data class InstagramResponseDTO(
    var `data`: Data? = null,
    var message: Any? = null,
    var status: String? = null
) {
    data class Data(
        var big_list: Boolean? = null,
        var has_more: Boolean? = null,
        var hashtag_count: Int? = null,
        var next_max_id: String? = null,
        var page_size: Int? = null,
        var preview_hashtags: List<PreviewHashtag?>? = null,
        var should_limit_list_of_followers: Boolean? = null,
        var use_clickable_see_more: Boolean? = null,
        var users: List<User?>? = null
    ) {
        data class PreviewHashtag(
            var follow_button_text: Any? = null,
            var follow_status: Int? = null,
            var id: String? = null,
            var media_count: Int? = null,
            var name: String? = null,
            var profile_pic_url: String? = null,
            var show_follow_drop_down: Boolean? = null,
            var subtitle: Any? = null
        )

        data class User(
            var account_badges: List<Any?>? = null,
            var fbid_v2: String? = null,
            var full_name: String? = null,
            var has_anonymous_profile_picture: Boolean? = null,
            var id: String? = null,
            var is_favorite: Boolean? = null,
            var is_private: Boolean? = null,
            var is_verified: Boolean? = null,
            var latest_reel_media: Int? = null,
            var pk: String? = null,
            var pk_id: String? = null,
            var profile_pic_id: String? = null,
            var profile_pic_url: String? = null,
            var strong_id__: String? = null,
            var third_party_downloads_enabled: Int? = null,
            var username: String? = null
        )
    }
}