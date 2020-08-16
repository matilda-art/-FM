/*
//找到数组中，所有 > 20 的数字

let arr = [1,3,5,7,2,4,6,8,10];
console.log(arr);

//让每个元素都 + 20，然后再 * 3，再除以 18

for(let i in arr){
    arr[i] = (arr[i] + 20) * 3 / 7
}
console.log(arr);

function func(a){
    let r = [];

    for(let i in a){
        if(a[i] > 10){
            r.push(a[i]);
        }
    }
    return r;
}

console.log(func(arr));
*/

let person = {
    name: "朱一龙",
    age: 32,
    gender: "男",
    sayHello: function (target) {
        if(!target) {
            target = "世界";
        }

        let message = "你好" + target;
        console.log(message);
    }
};

console.log(person.name);
console.log(person["age"]);
person.sayHello();  //你好，世界
person.sayHello("龙哥");    //你好，龙哥

for(let field in person) {
    console.log(field);
    console.log(person[field]);
}