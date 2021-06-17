printjson(db.people.aggregate([
	{$addFields: 
		{ bmi : 
			{ $divide : [ { $toDouble: "$weight" }, { $pow: [{ $divide : [ { $toDouble: "$height" }, 100]}, 2]}]}
		}
	},
	{$group : 
		{ _id : "$nationality", maxBmi : { $max : "$bmi"}, minBmi : { $min : "$bmi"}, avgBmi : { $avg : "$bmi"}}
	}
]).toArray())
