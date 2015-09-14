package cn.song.cdgenerics

/**
 * Created by hzsongzhengwang on 2015/9/14.
 */

// unlike Java, arrays in kotlin are invariant.
// This means that kotlin does not let us assign an Array<String> to an Array<Any>

// But you can use Array<out Any>.  See Kotlin-docs "Generics -- Type Projections"