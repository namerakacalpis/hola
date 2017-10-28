package com.hanakusoman.hola.models

import java.io.Serializable

/**
 * Created by taihe on 2017/10/22.
 */

data class Category(val name: String, val url: String) : Serializable

data class MenuItem(val name: String, val url: String) : Serializable