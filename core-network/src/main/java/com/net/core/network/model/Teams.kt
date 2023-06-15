package com.net.core.network.model

import kotlinx.serialization.Serializable
import java.util.ArrayList

@Serializable
data class Teams(
    var teams: ArrayList<TeamData>? = arrayListOf()
)
