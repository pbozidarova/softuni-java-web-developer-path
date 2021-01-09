function print(index){

    if(index == 0){
        return;
    }
    console.log('*'.padStart(index, '*'));
    print(index - 1);
    console.log('#'.padStart(index, '#'));

}
print(5);

