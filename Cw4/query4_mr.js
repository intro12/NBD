function mapFunction(){
    var bmi = parseFloat(this.weight) / Math.pow(parseFloat(this.height)/100,2);
    emit(this.nationality,bmi);
}

function reduceFunction(key,value){
    var result = {
	    avgBmi:  Array.avg(value),
	    minBmi:  Math.min(...value),
	    maxBmi:  Math.max(...value)
    }

    return result;
}

db.people.mapReduce(mapFunction, reduceFunction, { out : "query4_mr"})

printjson(db.query4_mr.find({}).toArray())
