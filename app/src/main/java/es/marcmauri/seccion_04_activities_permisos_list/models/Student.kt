package es.marcmauri.seccion_04_activities_permisos_list.models

import android.os.Parcel
import android.os.Parcelable

// Parcel es un contenedor para un mensaje
// Puede ser usado para mandar un objeto serializado a traves de Intent
// Mejor rendimiento que Serializer

data class Student(var name: String, var lastName: String, var age: Int, var isDeveloper: Boolean = true) : Parcelable {

    // Leer en el mismo orden que declaramos las propiedades
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte())

    override fun writeToParcel(destParcel: Parcel, flags: Int) {
        // Tenemos que escribir los valores en el mismo orden en el que leemos en el constructor
        destParcel.writeString(name)
        destParcel.writeString(lastName)
        destParcel.writeInt(age)
        destParcel.writeByte(if (isDeveloper) 1 else 0)
    }

    // Describe el tipo de contenido del objeto Parcelable
    // 0 siempre se usa, el otro valor es 1 o CONTENTS_FILE_DESCRIPTOR, para tipos de objetos que implementan un File Descriptor
    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Student> {
        // Esto creara el objeto desde el Parcel llamando al constructor SECUNDARIO
        override fun createFromParcel(source: Parcel) = Student(source)

        // Esto ayudara a serializar arrays de objetos del mismo tipo que esta clase (Student)
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)
    }
}