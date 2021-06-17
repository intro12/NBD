function mapFunction(){
	this.credit.forEach(c =>{
		emit(c.currency,parseFloat(c.balance));
	});
}

function reduceFunction(key,value){
    return Array.sum(value)
}

db.people.mapReduce(mapFunction, reduceFunction, { out : "query2_mr"})

printjson(db.query2_mr.find({}).toArray())
