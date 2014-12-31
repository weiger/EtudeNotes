#begin
Description:

We need a method for parsing an array of strings to see which of 3 categories they fall into:

:alpha strings contain the word "alpha"
:beta strings contain the word "beta"
:unknown strings don't contain either "alpha" or "beta"
:unknown is also used for nil entries
No string will contain both "alpha" and "beta"
The strings can contain alpha and beta in any case (e.g. "Alpha", "BeTa")
The input will be an array containing strings and nils. The output should be an array containing :alpha, :beta and :unknown symbols, based on the string at that index in the input array.

For example, the input:

["I'm Alpha", "No idea", "beta tester", nil]
should result in:
[:alpha, :unknown, :beta, :unknown]
#end

def line_types lines
  res = []
  i = 0
  lines.each do |x|
    if x == nil
      res[i] = :unknown
    elsif x.downcase.include?"alpha"
      res[i] = :alpha
    elsif x.downcase.include?"beta"
      res[i] = :beta
    else
      res[i] = :unknown
    end
    i = i + 1
  end
  res
end

def line_types lines
  lines.map { |line| line.to_s[/alpha|beta/i].downcase.to_sym rescue :unknown }
end

def line_types lines
  lines.map { |line| line =~ /(alpha|beta)/i ? $1.to_sym.downcase : :unknown }
end
