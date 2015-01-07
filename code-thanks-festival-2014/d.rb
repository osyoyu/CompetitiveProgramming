n, t = gets.split(" ").map(&:to_i)
a = Array.new
n.times do a.push(gets.to_i) end
max = 0
1.upto(t) do |i|
  max = [a.select{|e| i % e  == 0}.length, max].max
end
puts max
