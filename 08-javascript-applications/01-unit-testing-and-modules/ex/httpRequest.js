function httpRequest(request){
    let methods = [];

    if(!methods.includes(request.message)){
        throw new Error('Invalid request header: Invalid Method');
    }
}