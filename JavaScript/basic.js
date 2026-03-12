//factory function
function createRectangle(length,breadth){
    return rectangle={
        length,
        breadth,
        draw: function(){
            console.log("drawing function");
        }
    };
}
let rectangleObj1= createRectangle(5,4);
rectangleObj1.draw();
console.log(rectangleObj1.breadth);
let rectangleObj2=createRectangle(6,7);

//Constructor function -> pascal Notation(first letter of every word is capital)
function Rectangle(len, bre){
    this.length=len,
    this.breadth=bre,
    this.draw= function(){
        console.log('drawing');
    }
}
let RectObj1= new Rectangle(4,5);
RectObj1.draw();
console.log(RectObj1.breadth);
RectObj1.color="yellow";
console.log(RectObj1);
delete RectObj1.color;
console.log(RectObj1);
RectObj1.constructor;
Rectangle.constructor;