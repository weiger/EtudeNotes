#begin
Complete the solution so that it reverses the string value passed into it.
solution('world') # returns 'dlrow'
#end

def solution(str)
  str.reverse
end

def solution(str)
  final = ""
  str.split("").each {|x| final = x+final}
  return final
end
