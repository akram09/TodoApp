package akram.kero.todoapp.data.database_models

import org.jetbrains.exposed.sql.Table

object  UserTable :Table(){
    val id  = integer("UserId").primaryKey().autoIncrement()
    var uuid = uuid("Id").nullable()
    val email = varchar("mail", 254)
    val password = text("password")
}