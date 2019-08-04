package vs.js

fun wrapper(fn: (String, Int) -> Unit): (String) -> Unit {
    var id = 0;
    return { name ->
        id++;
        fn(name, id);
    }
}

val createPet = { name: String, id: Int ->
    println("szw $id -- $name")
}

// 下面代码是不行的, 在 val myWrapper = wrapper(createPet)这一行, 会说要求(stirng, int)->unit, 但得到的是void.
//fun createPet(name: String, id: Int) {
//    println("szw $id -- $name")
//}

fun main() {
    val myWrapper = wrapper(createPet)
    myWrapper("one")  //=> szw 1 -- one
    myWrapper("two")  //=> szw 2 -- two
}

/*
[js]
function wrapper(fn) {
  let id = 0;
  return function() {
    id++; // arguments = [Arguments] { '0': 'one' }
    const news = [...arguments, id];
    fn.apply(null, news, id);
  };
}

function createPet(name, sex, id = 0) {
  console.log(`a new pet [id = ${id}, name = ${name}, sex = ${sex}]`);
}

const funcWrapper = wrapper(createPet);
funcWrapper("one", true);
funcWrapper("two", false);

console.log(funcWrapper.id); //id因为是函数内局部变量, 所以不可访问. 但闭包里带着它了

/*

a new pet [id = 1, name = one]
a new pet [id = 2, name = two]
undefined
 */