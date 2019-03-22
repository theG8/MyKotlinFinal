package de.g8keeper.mykotlinfinal


/*
 'val' entspricht einer konstanten (final in java)
 'var' entspricht einer variable

 'data' vor 'class' fügt hinzu:
    copy-constructor(), toString(), equals() und hashCode()
 */


data class PersonK(
    var vName: String,
    var nName: String,
    var strasse: String,
    var hausNr: Int,
    var ort: String,
    var plz: String,
    var alter: Int,
    var isEmployee: Boolean
) {



}