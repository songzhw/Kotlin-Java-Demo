package vs.js;

import java.util.function.Consumer;

class Closure {
    public Consumer one(Consumer<String> fn) {
        int id = 0;
        return (s) -> {
//            id++; // 直接报错, 也就是说java并不支持如js中的闭包(持有局部变量并能修改它)
            System.out.println("");
        };
    }
}

public class 闭包 {
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