n = gets.to_i
a = gets.chomp.split(' ').map(&:to_i)

alice_ttl = 0
bob_ttl = 0
a.sort!.reverse.each_slice(2) do |alice, bob|
  alice_ttl += alice
  bob_ttl += (bob || 0)
end

puts alice_ttl - bob_ttl
