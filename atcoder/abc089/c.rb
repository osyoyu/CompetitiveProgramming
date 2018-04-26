N = gets.to_i
names = Hash.new(0)
N.times do
  name = gets.chomp
  names[name[0]] += 1
end

ans = 0
%w(M A R C H).combination(3).to_a.each do |s|
  ans += names[s[0]] * names[s[1]] * names[s[2]]
end

puts ans
