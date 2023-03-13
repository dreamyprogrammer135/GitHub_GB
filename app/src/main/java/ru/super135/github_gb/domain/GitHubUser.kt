package ru.super135.github_gb.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GitHubUser(
    val login: String
) : Parcelable
