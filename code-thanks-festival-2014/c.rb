n = gets.to_i
v = gets.split(" ").map(&:to_i)
f = gets.split(" ").map(&:to_i)
count = 0
n.times do |i| count += 1 if f[i] > v[i] / 2 end
puts count