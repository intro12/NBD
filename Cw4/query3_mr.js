function mapFunction(){
	emit(this.job,null)
}

function reduceFunction(key,value){
    return 1
}

db.people.mapReduce(mapFunction, reduceFunction, { out : "query3_mr"})

printjson(db.query3_mr.find({}).toArray())
