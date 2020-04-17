package kotlinExmpl

class Person(firstName: String, private var lastName: String, private var age: Int, private var role: String, private var attr: List<String>) {
    private var firstName: String = firstName.capitalize()

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
