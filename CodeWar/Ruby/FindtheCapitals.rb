#begin
Description:

Write a method that takes an array of hashes with two keys each: country or state, and capital. Keys may be symbols or strings

The method should return an array of sentences declaring the state or country and its capital.

Examples

state_capitals = [{state: 'Maine', capital: 'Augusta'}]
capital(state_capitals)[0] # returns "The capital of Maine is Augusta"

country_capitals = [{'country' => 'Spain', 'capital' => 'Madrid'}]
capital(country_capitals)[0] # returns "The capital of Spain is Madrid"

mixed_capitals: [{"state" => 'Maine', capital: 'Augusta'}, {country: 'Spain', "capital" => "Madrid"}]
capital(mixed_capitals)[0] # returns "The capital of Maine is Augusta"
#end

def capital(capitals_hash_array)
  capitals_hash_array.map {|cc| "The capital of #{cc[:state] || cc['state'] || cc[:country] || cc['country']} is #{cc[:capital] || cc['capital']}"}
end

def capital(capitals_hash_array)
  capitals_hash_array.map do |data|
    "The capital of #{data.search(:state, :country)} is #{data.search(:capital)}"
  end
end

class Hash
  def search(*keys)
    keys.each do |key|
      value = self[key] || self[key.to_s]
      return value if value
    end
  end
end

def capital(capitals_hash_array)
  capitals_hash_array.map do |hsh|
    state = hsh[:state] || hsh["state"] || hsh[:country] || hsh["country"]
    capital = hsh[:capital] || hsh["capital"]
    "The capital of #{state} is #{capital}"
  end
end
