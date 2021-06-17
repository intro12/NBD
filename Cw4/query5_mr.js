function mapFunction(){
	if(this.nationality == "Poland" && this.sex == "Female" ){

	this.credit.forEach(c =>{
		emit(c.currency,parseFloat(c.balance));
	});
	};
}

function reduceFunction(key,value){
	var result = {
		suma: Array.sum(value),
		avg: Array.avg(value)
	}
    return result
}

db.people.mapReduce(mapFunction, reduceFunction, { out : "query5_mr"})

printjson(db.query5_mr.find({}).toArray())
