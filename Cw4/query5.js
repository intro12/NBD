printjson(db.people.aggregate(
	{ $match : { nationality: "Poland", sex: "Female" } },
	{ $unwind: { path: "$credit" } },
	{ $group: {
		_id: "$credit.currency",
		sum: { $sum: { $toDouble: "$credit.balance" } },
		avg: { $avg: { $toDouble: "$credit.balance" } }
	} }
).toArray())
