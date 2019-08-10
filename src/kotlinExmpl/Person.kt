package kotlinExmpl

class Person {
    var firstName: String
    var lastName: String
    var age: Int
    private var role: String
    var attr: List<String>

    constructor(firstName: String, lastName: String, age: Int, role: String, attr: List<String>) {
        this.lastName = lastName
        this.age = age
        this.role = role
        this.attr = attr
        this.firstName = firstName.capitalize()
    }

    fun setRole(role:String){
        this.role=role;
    }

    fun getFullName(): String {
        return "$lastName $firstName is $age years old."
    }

    fun getRole():String {
        return this.role;
    }


}
