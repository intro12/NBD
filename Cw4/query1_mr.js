function mapFunction(){
    emit(this.sex,{ avgweight: parseFloat(this.weight), avgheight: parseFloat(this.height) });
}

function reduceFunction(key,value){
    var heights = value.map(x => x.avgheight);
    var weights = value.map(x => x.avgweight);
    var avg = {
        avgHeight: Array.avg(heights),
        avgWeight: Array.avg(weights)
    }

    return avg;
}

db.people.mapReduce(mapFunction, reduceFunction, { out : "query1_mr"})

printjson(db.query1_mr.find({}).toArray())
