import sys

class SimpleDB(object):

	usageInfo = """SimpleDB v1.0
Usage:
	command [name] [value]
The commands are:
	SET name value: Set variable name to value
	GET name: Get value of variable name
	UNSET name: Clear variable name
	NUMEQUALTO value: Get the number of variables that are set to value
	END: Exit the program

	BEGIN: Open a new operation block
	ROLLBACK: Undo all of commands in recent operation block
	COMMIT: Close all blocks and apply changes"""

	def __init__(self):
		# History for rollback
		self.history = []
		# Dict for stora key, value pair
		self.database = {}
		# Record for number of specific value
		self.record = {}

	def apply(self, key, val):
		# write to the database, if value is None, we remove the variable from the database
		if (val != None):
			self.database[key] = val
			self.addToRecord(val)
		else:
			if key in self.database:
				del self.database[key]
			
	def begin(self):
		# creates a new transaction history
		# Time Complexity: O(1)
		self.history.append({})

	def rollback(self):
		# if we have a transaction history, read from the most recent and apply rollbacks
		if (self.history):
			for key, val in self.history[len(self.history) - 1].items():
				self.apply(key, val)
			# remove the most recent transaction history
			self.history.pop()
			# Update record
			self.record.clear()
			for key, val in self.database.items():
				self.addToRecord(val)
		else:
			print "INVALID ROLLBACK"

	def commit(self):
		# The current status of database is the latest
		# if commit now, nothing needs to change, just clear history
		self.history = []

	def set(self, name, val):
		# Set new key, value in database and also update history
		# Ex:  before "BEGIN" database: {A: 1, B: 2} history: []
		#      after "BEGIN" set C:3 database: {A: 1, B: 2, C: 3} history: [C:None]	
		#                    set B:1 database: {A: 1, B: 1, C: 3} history: [C:None, B: 2]
		# Time Complexity: O(1), database and history are all hashtable structure	
		if (self.history):
			# update the history for items that are changed in this transaction level
			if name in self.database and name not in self.history[len(self.history) - 1]:
				self.history[len(self.history) - 1][name] = self.database[name]
			if name not in self.database:
				self.history[len(self.history) - 1][name] = None
		self.apply(name, val)

	def get(self, name):
		# Get value by name from database
		# Time Complexity: O(1), get value from hashtable
		if name in self.database:
			print self.database[name]
		else:
			print 'NULL'

	def unset(self, name):
		# Unset value by name from database
		# Time Complexity: O(1), openaate on hashtable
		if name in self.database:
			self.deleteFromRecord(self.database[name])
			self.set(name, None)

	def numequalto(self, val):
		# Check from record to get number of specific value
		# Time Complexity: O(1), openaate on hashtable
		if val in self.record:
			print self.record[val]
		else:
			print 0
	
	def addToRecord(self, val):
		# Add new value to record
		if val not in self.record:
			self.record[val] = 1
		else:
			self.record[val] += 1

	def deleteFromRecord(self, val):
		# Delete value from record
		if val in self.record:
			self.record[val] -= 1
			if self.record[val] == 0:
				del self.record[val]

	def start(self):
		# Driver to get database started
		print self.usageInfo
		line = sys.stdin.readline().strip().lower()
		while line != 'end':
			args = line.split(' ')
			legalCmds = ['begin', 'rollback', 'commit', 'set', 'get', 'unset', 'numequalto']
			if args[0] in legalCmds:
				f = getattr(self, args[0]);
				f(*args[1:])
			else:
				print "Unknown Command "
			line = sys.stdin.readline().strip().lower()
			
if __name__ == "__main__":
	db = SimpleDB()
	db.start()

	
