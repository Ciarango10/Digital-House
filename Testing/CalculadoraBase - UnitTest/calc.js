function suma(a,b){
    if(isNaN(a) || isNaN(b)) {
        return 0;
    } else {
        return a+b;
    }
}

function resta(a,b){
    if(isNaN(a) || isNaN(b)) {
        return 0;
    } else {
        return a-b;
    }
}

function multiplicacion(a,b){
    if(isNaN(a) || isNaN(b)) {
        return 0;
    } else {
        return a*b;
    }
}

function division(a,b){
    if(isNaN(a) || isNaN(b) || a == 0 || b == 0 || a == null || b == null) {
        return 0;
    }
    else {
        return a/b;
    }
}

module.exports = {suma, resta, multiplicacion, division};
