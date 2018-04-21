dict = Hash.new(0)

N = gets.to_i
N.times do
  input = gets.chomp
  dict[input] += 1
end

M = gets.to_i
M.times do
  input = gets.chomp
  dict[input] -= 1
end

ans = dict.to_a.sort_by {|i| i[1]}.last[1]
puts [ans, 0].max
