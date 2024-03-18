Classes - Constructor

class Rectangle {
    constructor(height, width){
        this.height = height;
        this.width = width;
    }

    get area(){
        return this,calcArea();
    }

    calcArea(){
        return this.height * this.width;
    }
}

const square = new Rectangle (10, 10);
console.log(square.area);

class Animal{
    constructor(name){
        this.name = name;
    }

    speak(){
        console.log(`${this.name} makes a noise`);
    }
}

class Dog extends Animal{
    constructor(name){
        super(name);
    }
    speak(){
        console.log(`${this.name} barks.`);
    }
}

const d = new Dog("Mitzie")
d.speak();